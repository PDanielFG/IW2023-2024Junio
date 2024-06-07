package com.example.application.views;

import com.example.application.data.service.UserService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import org.springframework.beans.factory.annotation.Autowired;

@AnonymousAllowed
@PageTitle("Register")
@Route(value = "register")
@RouteAlias(value = "signup")
public class RegisterView extends VerticalLayout {

    private final UserService userService;

    public RegisterView(@Autowired UserService userService) {
        this.userService = userService;

        // Campos de entrada para el registro
        TextField usernameField = new TextField("Username");
        TextField nameField = new TextField("Name");
        TextField emailField = new TextField("Email");
        PasswordField passwordField = new PasswordField("Password");
        PasswordField confirmPasswordField = new PasswordField("Confirm Password");

        // Botón de registro
        Button registerButton = new Button("Register", event -> {
            // Obtener los valores de los campos de entrada
            String username = usernameField.getValue();
            String name = nameField.getValue();
            String email = emailField.getValue();
            String password = passwordField.getValue();
            String confirmPassword = confirmPasswordField.getValue();

            // Verificar si las contraseñas coinciden
            if (!password.equals(confirmPassword)) {
                Notification.show("Passwords do not match!");
                return;
            }

            // Registrar el usuario utilizando el servicio UserService
            try {
                userService.registerUser(username, name, email, password);
                Notification.show("User registered successfully!");
            } catch (RuntimeException e) {
                Notification.show(e.getMessage());
            }
        });

        // Crear un diseño vertical para el formulario de registro
        VerticalLayout formLayout = new VerticalLayout(usernameField, nameField, emailField, passwordField, confirmPasswordField, registerButton);
        formLayout.setAlignItems(Alignment.CENTER);
        formLayout.setJustifyContentMode(JustifyContentMode.CENTER);
        formLayout.setSizeUndefined();

        // Añadir el diseño del formulario al diseño principal
        add(formLayout);
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        setSizeFull();
    }
}
