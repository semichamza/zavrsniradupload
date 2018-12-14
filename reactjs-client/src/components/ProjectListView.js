import React from 'react';

import axios from 'axios';
import Project from './Project';


export default class ProjectListView extends React.Component {
    state = {
        projects:[],
        freelancers:[]
    }

    setFreelancersForProject = (freelancerList,idx) => {
        let freelancers = [...this.state.freelancers];
        freelancers[idx] = freelancerList;
        console.log(freelancers);
        this.setState({freelancers});
    }

    componentDidMount(){
        axios.get('http://localhost:3001/api/projects').then((response)=>{
            const projects = response.data;
            const freelancers = new Array(projects.length);
            this.setState({projects,freelancers});
        })
    }

    render(){
        return (
            <div>
                {
                    !!this.state.projects &&
                    this.state.projects.map((project,idx)=>
                        <Project project={project} freelancers={this.state.freelancers[idx]} index={idx} setFreelancersForProject={this.setFreelancersForProject}/>
                    )
                }
            </div>
        )
    }
}