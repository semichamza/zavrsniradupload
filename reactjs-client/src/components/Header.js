import React from 'react';
import { Link } from 'react-router-dom'

const Header = ()=>(
    <nav>
        <div className="nav-wrapper">
        <a href="#" className="brand-logo right">Project Search</a>
        <ul id="nav-mobile" className="left hide-on-med-and-down">
            <li><Link to='/projects'>Projects</Link></li>
            <li><Link to='/freelancers'>Freelancers</Link></li>
        </ul>
        </div>
    </nav>
)

export default Header;