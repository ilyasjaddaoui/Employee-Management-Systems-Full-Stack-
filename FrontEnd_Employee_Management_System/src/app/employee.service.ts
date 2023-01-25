import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseUrl= "http://localhost:8080/employees";
  constructor( private httpClient: HttpClient ) { }

  getEmployeesList(): Observable<Employee[]>{
    return this.httpClient.get<Employee[]>(`${this.baseUrl}`);
  }

  addEmployee(employee:Employee): Observable<Object> {
    return this.httpClient.post(`${this.baseUrl+"/add"}`,employee)
  }

  updateEmployee(id: number, employee:Employee): Observable<Object>{
      return this.httpClient.put(`${this.baseUrl+"/add"}/${id}`, employee);
  }

  getEmployeeById(id: number):Observable<Employee>{
    return this.httpClient.get<Employee>(`${this.baseUrl}/${id}`);
  }

  deleteEmployee(id:number):Observable<Object>{
    return this.httpClient.delete(`${this.baseUrl+"/delete"}/${id}`);
  }
}
