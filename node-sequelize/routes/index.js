var express = require('express');
var router = express.Router();

const userController = require('../controllers').user;
const skillController = require('../controllers').skill;

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Express' });
});
router.get('/api/user', userController.list);
router.get('/api/user/:id', userController.getById);
router.post('/api/user', userController.add);
router.put('/api/user/:id', userController.update);
router.delete('/api/user/:id', userController.delete);
router.post('/api/user/add_skill', userController.addSkill);
router.post('/api/user/find_users_by_skills', userController.findUsersBySkills);

router.get('/api/skill', skillController.list);
router.get('/api/skill/:id', skillController.getById);
router.post('/api/skill', skillController.add);
router.put('/api/skill/:id', skillController.update);
router.delete('/api/skill/:id', skillController.delete);

module.exports = router;
