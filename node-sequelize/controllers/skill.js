const User = require('../models').User;
const Skill = require('../models').Skill;

module.exports = {
    list(req, res) {
        return Skill
            .findAll({
                include: [{           
                    model: User,
                    as: 'users'
                }],
            })
            .then((skills) => res.status(200).send(skills))
            .catch((error) => {res.status(400).send(error);});
    },

    getById(req, res) {
        return Skill
            .findById(req.params.id, {
                include: [{
                    model: User,
                    as: 'users'
                }],
            })
            .then((skill) => {
                if(!skill) {
                    return res.status(404).send({
                        message: 'Skill not found'
                    });
                }
                return res.status(200).send(skill);
            })
            .catch((error) => res.status(400).send(error));
    },

    add(req, res) {
        return Skill
            .create({
                title: req.body.title
            })
            .then((skill) => res.status(201).send(skill))
            .catch((error) => res.status(400).send(error));

    },

    update(req, res) {
        return Skill
            .findById(req.params.id, {
                include: [{
                    model: User,
                    as: 'users'
                }],
            })
            .then((skill) => {
                if(!skill) {
                    return res.status(404).send({
                        message: 'Skill not found'
                    });
                }
                return skill
                    .update({
                        title: req.body.title
                    })
                    .then(() => res.status(200).send(skill))
                    .catch((error) => res.status(400).send(error));
            })
            .catch((error) => res.status(400).send(error));
    },

    delete(req, res) {
        return Skill
            .findById(req.params.id)
            .then(skill => {
                if(!skill) {
                    return res.status(400).send({
                        message: 'Skill not found'
                    });
                }
                return skill
                    .destroy()
                    .then(() => res.status(204).send())
                    .catch((error) => res.status(400).send(error));
            })
            .catch((error) => res.status(400).send(error));
    },

};