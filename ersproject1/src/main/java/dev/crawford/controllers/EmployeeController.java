package dev.crawford.controllers;


import dev.crawford.services.EmployeeService;
import io.javalin.http.Handler;

public final class EmployeeController {
    
    private static EmployeeService employeeService = new EmployeeService();

    
    public static final Handler hello = ctx -> {
        ctx.redirect("/index.html");
    };

    public static final Handler before = ctx -> {
        System.out.println("Before all requests");
    };

    // Create Employee Using JSON
    public static final Handler createEmployee = ctx -> {
        employeeService.createEmployee(ctx);
    };

    // Create Employee Using Form-Encoded
    public static final Handler createFormEmployee = ctx -> {
        System.out.println(ctx.body());
        employeeService.createFormEmployee(ctx);
    };

    // Get all Employees
    public static final Handler getAllEmployees = ctx -> {
        ctx.json(employeeService.getAllEmployees());
    };

    //Get Employee by Unique value of Email
    public static final Handler getEmployeeByEmail = ctx -> {
        ctx.json(employeeService.getEmployeeByEmail(ctx.pathParam("email")));
    };

    // DELETE ALL ------ NOT FOR PRODUCTION!!!
    public static final Handler deleteAllEmployees = ctx -> {
        employeeService.deleteAll();
    };

}
