import React from 'react';
import axios from 'axios';
import Freelancer from './Freelancer';

const Project = (props) => (
    <div className="card blue-grey darken-1">
        <div className="card-content white-text">
            <span className="card-title">Creator: {props.project.creator}</span>
            <div>Description: {props.project.description}</div>
            <div>Skills needed: {props.project.skills.toString()}</div>
            <div><button className="btn" onClick={()=>{
                axios.get("http://localhost:3001/api/projects/"+props.project.id+'/findWorkers').then((response)=>{
                    console.log(response.data);
                    props.setFreelancersForProject(response.data,props.index);
                })}
            }>Show appropriate freelancers</button></div>
            {
                !!props.freelancers && props.freelancers.map((freelancer)=>(
                    <Freelancer user={freelancer}/>
                ))
            }
        </div>
    </div>
);

export default Project;