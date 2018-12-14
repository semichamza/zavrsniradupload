import React from 'react';

import axios from 'axios';
import Freelancer from './Freelancer';


export default class FreelancerList extends React.Component {
    state = {
        users:[]
    }

    componentDidMount(){
        axios.get('http://localhost:3001/api/freelancers').then((response)=>{
            const users = response.data;

            this.setState({users});
        })
    }

    render(){
        return (
            <div>
                {
                    !!this.state.users &&
                    this.state.users.map((user)=>
                        <Freelancer user={user} />
                    )
                }
            </div>
        )
    }
}