import { Component } from "react";
import StudentService from "../service/StudentService";

class ListStudentComponent extends Component{
    constructor(props){
        super(props)
        this.state = {
            students: []
        }
        this.refreshStudents = this.refreshStudents.bind(this)
        this.deleteStudentClicked = this.deleteStudentClicked.bind(this)
        this.updateStudentClicked = this.updateStudentClicked.bind(this)
        this.addNewStudent = this.addNewStudent.bind(this)
    }

    componentDidMount(){
        this.refreshStudents();
    }

    refreshStudents(){

        StudentService.findAllStudents().then(response => {
            console.log(response.data);
            this.setState({students: response.data });
        });
    }

    deleteStudentClicked(id){

        StudentService.deleteStudentById(id).then(response => {
            console.log(response.data);
            this.refreshStudents()
        });
    }

    updateStudentClicked(id){
        this.props.history.push(`/add-student/${id}`);
    }

    addNewStudent(){
        // this.props.history.push(`/add-student/_add`);
        this.props.history.push(`/add-student/-1`);
    }


    render(){
        return(
           <div className="app">
               <h2> List of Students </h2>

                <div>
                <button className="btn btn-add" onClick={this.addNewStudent}> Add Student </button>
               </div>

               
               <div className = "container">
                   <table className="table">
                   <thead>
                       <tr>
                           <th>Student ID</th>
                           <th> Student Name </th>
                           <th> Student Email </th>
                       </tr>
                   </thead>
                    <tbody>
                      
                        {
                            this.state.students.map(
                                student =>
                                <tr key={student.studentId}>
                                    <td>{student.studentId}</td>
                                    <td> {student.studentName}</td>
                                    <td> {student.studentEmail}</td>
                                    <td><button className="btn btn-confirmation"onClick={() => this.deleteStudentClicked(student.studentId)}> Delete </button> </td>
                                    <td><button className="btn btn-update" onClick={() => this.updateStudentClicked(student.studentId)}> Update </button> </td>
                                </tr>
                            )
                        
                        }
                    </tbody>
                    </table>
               </div>
           </div>
        )
    }
}

export default ListStudentComponent