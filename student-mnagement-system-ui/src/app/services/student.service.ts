import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Student} from '../entity/student';
 
@Injectable({
  providedIn: 'root'
})
export class StudentService {

  constructor(private http: HttpClient) { }

  configUrl = 'http://localhost:8013/students';
  students:Student[] = null;

  getConfig() {
    return this.http.get(this.configUrl);
  }  

  private studentsUrl:string = 'http://localhost:8013/students'; 
  // private log(message: string) {
  //   this.messageService.add(`HeroService: ${message}`);
  // }

  getHeroes (): Observable<Student[]> {
    return this.http.get<Student[]>(this.studentsUrl);
  }

  getStudents (): Observable<Student[]> {
    return this.http.get<Student[]>(this.studentsUrl);
  }

  getStudent(id:number):Observable<Student>{
    return this.http.get<Student>(`${this.studentsUrl}/${id}`);
  }

  deleteStudent(id:number){
    return this.http.delete<Student>(`${this.studentsUrl}/${id}`);
  }

  addStudent(student:Student):Observable<Student>{
    return this.http.post<Student>(this.studentsUrl,student);
  }

  findAllStudents():Observable<Student[]>{
    return this.http.get<Student[]>(`${this.studentsUrl}`);
  }  

  getAllEmployeesByPage(page:number, pageSize:number, sortBy:string):Observable<Student[]>{
    return this.http.get<Student[]>(`${this.studentsUrl}${page}/${pageSize}/${sortBy}`);
  }
}
