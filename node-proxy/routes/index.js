var express = require('express');
var axios = require('axios');
var router = express.Router();

const projectsPath = "http://localhost:8080";
const freelancersPath = "http://localhost:3000/api";

router.get('/projects',(req,res)=>{
  axios.get(projectsPath+'/projects').then(
    (response)=>{
      res.json(response.data);
    }
  );
})

router.get('/freelancers',(req,res)=>{
  axios.get(freelancersPath+'/user').then(
    (response)=>{
      res.json(response.data);
    }
  )
})

router.get('/projects/:id/findWorkers',(req,res)=>{
  axios.get(projectsPath+'/projects/'+req.params.id+'/skills').then((projectResponse)=>{
    const projectSkills = projectResponse.data;
    axios.post(freelancersPath+"/user/find_users_by_skills",{'skills':projectSkills}).then((freelancersResponse)=>{
      res.json(freelancersResponse.data);
    })
  })
})



module.exports = router;
