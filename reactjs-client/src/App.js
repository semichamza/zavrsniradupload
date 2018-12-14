import React, { Component } from 'react';
import Header from './components/Header';
import {BrowserRouter as Router,Route,Switch} from 'react-router-dom';
import ProjectListView from './components/ProjectListView';
import './App.css';

import 'materialize-css/dist/css/materialize.min.css'
import 'materialize-css/dist/js/materialize.min.js'
import FreelancerList from './components/FreelancerList';

class App extends Component {
  render() {
    return (
      <div className="App">
      <Router>
      <div>
        <Header/>
        <Switch>
          <Route exact path='/'  component={()=><div className="container"><h2>Welcome to Project Search Platform. Choose one of the menu options to start your search!</h2></div>}/>
          <Route path="/projects" component={ProjectListView}/>
          <Route path="/freelancers" component={FreelancerList}/>
        </Switch>

      </div>
    </Router>
    </div>
    );
  }
}

export default App;
