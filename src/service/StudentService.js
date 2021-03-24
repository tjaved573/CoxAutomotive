import axios from 'axios'

const url = "http://localhost:8080/api/students";

class StudentService{
    
    findAllStudents(){
        return axios.get(url);
    }

    findStudentById(id){
        return axios.get(`${url}/${id}`);
    }

    deleteStudentById(id){
        return axios.delete(`${url}/${id}`);
    }


    updateStudentById(id, student){
        return axios.put(`${url}/${id}`, student);
    }

    addNewStudent(student){
        return axios.post(url, student);
    }

}

export default new StudentService()