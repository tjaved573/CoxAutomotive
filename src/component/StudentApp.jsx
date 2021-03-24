import React, { Component } from 'react';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import ListStudentComponent from './ListStudentComponent.jsx';
import CreateStudentComponent from './CreateStudentComponent.jsx';


class StudentApp extends Component {

    render() {
        return (
        <Router>
            <div className = "container">
                <Switch>
                    <Route path = "/" exact component = {ListStudentComponent}></Route>
                    <Route path = "/students" exact component = {ListStudentComponent}></Route>
                    <Route path = "/add-student/:studentId" component = {CreateStudentComponent}></Route>
                </Switch>
            </div>
        </Router>
        );
    }
}

export default StudentApp;
