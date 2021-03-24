import { Component } from "react";
import StudentService from "../service/StudentService";
class CreateStudentComponent extends Component{


    constructor(props){
        super(props)

        this.state={
            studentId: this.props.match.params.studentId,
            studentName: '',
            studentEmail: '',
            buttonDisabled: false
        }

        this.changeIdHandler = this.changeIdHandler.bind(this);
        this.changeEmailHandler = this.changeEmailHandler.bind(this);
        this.changeNameHandler = this.changeNameHandler.bind(this);
        this.cancel = this.cancel.bind(this);
    }

    componentDidMount(){

        if(this.state.studentId === "-1"){
            this.setState({studentId: ""})

        }else{
            this.setState({buttonDisabled: true})
        }
    }

    changeIdHandler = (event) =>{
        this.setState({studentId: event.target.value});
    }

    changeNameHandler = (event) =>{
        this.setState({studentName: event.target.value});
    }

    changeEmailHandler = (event) =>{
        this.setState({studentEmail: event.target.value});
    }

    editEmployee = (event) => {
        
        let student = {studentId: this.state.studentId, studentName: this.state.studentName, studentEmail: this.state.studentEmail};

        if (this.state.disabled === true){
            StudentService.addNewStudent(student).then ((res) => {
                this.props.history.push('/students');
            })
        } else {
            StudentService.updateStudentById(this.state.studentId, student).then ((res) => {
                this.props.history.push('/students');
            });
        }

    }

    cancel(){
        this.props.history.push('/students');
    }

    getHeaderTitle(){
        console.log(this.state.studentId)
        if  (this.state.studentId === ""){
            return <h2> Add New Student </h2>
        } else {
            return <h2> Update Current Student </h2>
        }
    }

    render(){
        return (
            <div>
                <div>
                    {this.getHeaderTitle()}
                </div>
                <div className="body">
                    <form>
                        <div className="form-group">
                            <label> Student ID: </label>
                            <input placeholder = "Student ID" name="studentId" disabled={this.state.buttonDisabled} className="form-control"
                            value={this.state.studentId} onChange={this.changeIdHandler}/>
                        </div>

                        <div className="form-group">
                            <label> Student Name: </label>
                            <input placeholder = "Student Name" name="studentName" className="form-control"
                            value={this.state.studentName} onChange={this.changeNameHandler}/>
                        </div>

                        <div className="form-group">
                            <label> Student Email: </label>
                            <input placeholder = "Student Email" name="studentEmail" className="form-control"
                            value={this.state.studentEmail} onChange={this.changeEmailHandler}/>
                        </div>
                    </form>
                </div>

                <div>
                    <button className="btn" onClick={this.editEmployee}> Save </button>
                    <button className="btn left:20px" onClick={this.cancel}> Return to Main Page </button>
                </div>

            </div>
        )
    }
}

export default CreateStudentComponent;