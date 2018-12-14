var bcrypt = require('bcryptjs');
var amqp = require('amqplib/callback_api');
const User = require('../models').User;
const Skill = require('../models').Skill;

module.exports = {
    list(req, res) {
        return User
            .findAll({
                include: [{           
                    model: Skill,
                    as: 'skills'
                }],
            })
            .then((users) => res.status(200).send(users))
            .catch((error) => {res.status(400).send(error);});
    },

    getById(req, res) {
        return User
            .findById(req.params.id, {
                include: [{
                    model: Skill,
                    as: 'skills'
                }],
            })
            .then((user) => {
                if(!user) {
                    return res.status(404).send({
                        message: 'User not found'
                    });
                }
                return res.status(200).send(user);
            })
            .catch((error) => res.status(400).send(error));
    },

    add(req, res) {
        return User
            .create({
                username: req.body.username,
                password: bcrypt.hashSync(req.body.password,12),
                mail: req.body.mail
            })
            .then((user) => res.status(201).send(user))
            .catch((error) => res.status(400).send(error));

    },

    update(req, res) {
        return User
            .findById(req.params.id, {
                include: [{
                    model: Skill,
                    as: 'skills'
                }],
            })
            .then((user) => {
                if(!user) {
                    return res.status(404).send({
                        message: 'User not found'
                    });
                }
                return user
                    .update({
                        username: req.body.username,
                        mail: req.body.mail
                    })
                    .then(() => res.status(200).send(user))
                    .catch((error) => res.status(400).send(error));
            })
            .catch((error) => res.status(400).send(error));
    },

    delete(req, res) {
        return User
            .findById(req.params.id)
            .then(user => {
                if(!user) {
                    return res.status(400).send({
                        message: 'User not found'
                    });
                }
                return user
                    .destroy()
                    .then(() => res.status(204).send())
                    .catch((error) => res.status(400).send(error));
            })
            .catch((error) => res.status(400).send(error));
    },

    addSkill(req, res) {
        return User
            .findById(req.body.user_id, {
                include: [{
                    model: Skill,
                    as: 'skills'
                }],
            })
            .then((user) => {
                if(!user) {
                    return res.status(404).send({
                        message: 'User not fount'
                    });
                }
                Skill.findOne({where: {title: req.body.title}}).then(skill=>{
                    if(!skill){
                        Skill.create({title: req.body.title}).then(skillNew=>{
                            user.addSkill(skillNew);
                            amqp.connect('amqp://localhost', function(err, conn) {
                            conn.createChannel(function(err, ch) {
                                var ex = 'skills';
                                var msg = req.body.title;

                                ch.assertExchange(ex, 'fanout', {durable: true});
                                ch.publish(ex, '', new Buffer(msg));
                                console.log(" [x] Sent %s", msg);
                            });

                            });

                        return res.status(200).send(user);
                        })
                    }
                    else{
                        user.addSkill(skill);
                        return res.status(200).send(user);
                    }
                })
            })
            .catch((error) => res.status(400).send(error));
    },

    findUsersBySkills(req, res) {
        console.log(req.body.skills);
        return User
            .findAll({
                include:[
                    {model: Skill, as: "skills", where: {title: {$in: req.body.skills}}}
                ]
            })
            .then((users) => {
                if(!users) {
                    return res.status(200).send({
                        message: 'There are no users for required skills!'
                    });
                }
                return res.status(200).send(users);
            })
            .catch((error) => res.status(400).send(error));
    }

};