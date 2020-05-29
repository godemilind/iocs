import { Component, OnInit, ViewChild } from '@angular/core';
import { StudentService } from 'src/app/services/student.service';
import { Student } from 'src/app/entity/student';
import { DataTableDirective } from 'angular-datatables';
import { faEdit } from '@fortawesome/free-solid-svg-icons';
import { faTrash } from '@fortawesome/free-solid-svg-icons';
import { Subject } from 'rxjs';

declare var $ :any;

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})

export class DashboardComponent implements OnInit {
  faEdit=faEdit;
  faTrash=faTrash;

  public students:Student[]=[];
  student:Student=new Student();
  page:number=0;
  pageSize:number=2;
  sortBy:string='id';
  submitted = false;
  title = 'angulardatatables';
  //@ViewChild(DataTableDirective)
  dtElement: DataTableDirective;
  dtOptions: DataTables.Settings = {};

  add:boolean=true;

  dtTrigger: Subject<any> = new Subject();

constructor(private studentService: StudentService) { }
  
public data = [
  {name: 'therichpost', email: 'therichpost@gmail.com', website:'therichpost.com'},
  {name: 'therichpost', email: 'therichpost@gmail.com', website:'therichpost.com'},
  {name: 'therichpost', email: 'therichpost@gmail.com', website:'therichpost.com'},
  {name: 'therichpost', email: 'therichpost@gmail.com', website:'therichpost.com'},
];

  ngOnInit() {
    this.dtOptions = {
      pagingType: 'full_numbers',
      pageLength: 2,
      processing: true
    };

    this.studentService.findAllStudents().subscribe((students:Student[])=>{
      this.students=students;
       // ADD THIS
      this.dtTrigger.next();
    });    
  }

  addStudent(){
    this.student = new Student();
  }

  editStudent(student: Student){
    this.student = student;
  }

  deleteStudent(id){
    this.studentService.deleteStudent(id).subscribe((student:Student)=>{
      this.studentService.findAllStudents().subscribe((students:Student[])=>{
        this.students = students;
        console.log(this.students);
      });
    });
  }

  updateStudent(student){
    console.log(student);
    $("#student-form").modal("hide");
    this.studentService.addStudent(student).subscribe((student:Student)=>{
      console.log(this.student);
      this.studentService.findAllStudents().subscribe((students:Student[])=>{
        this.students = students;
        console.log(this.students);
      }); 
    });    
  }

}
