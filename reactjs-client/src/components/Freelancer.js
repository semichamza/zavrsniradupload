import React from 'react';


const Freelancer = (props) => (
    <div className="card blue-grey darken-1">
        <div className="card-content white-text">
            <span className="card-title">Username: {props.user.username}</span>
            <div>Email: {props.user.mail}</div>
            {!!props.user.skills.length && <div>
            
                Skills: <ul>{!!props.user.skills && props.user.skills.map(
                    (skill)=>(<li> {skill.title} </li>)
                    
                )}</ul>
            
            </div>}
        </div>
    </div>
);

export default Freelancer;