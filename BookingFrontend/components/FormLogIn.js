import React, { useState } from 'react';
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import "./Form.css";

export const FormLogIn = (props) => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState('');
    const [userDB, setUserDB] = useState([]);
    function handleChange(e) {
        e.preventDefault();
        const { name, value } = e.target;
        switch (name) {
            case 'email':
                setEmail(value);
                break;
            case 'password':
                setPassword(value);
                break;
            default:
                break;
        }
    }

    function validateForm() {
        return email.length > 0 && password.length > 0;
    }

    async function loginClicked(e) {
        e.preventDefault();
        await fetch('api/v1/user/getUsers')
          .then(response => response.json())
          .then(data => {
            setUserDB(data);
          })
          for (let i = 0; i < userDB.length; i++) {
            if (email === userDB[i].email && password === userDB[i].password) {
                props.toggleUserID(userDB[i].id);
                console.log("Login Success");
                props.connection(true);
                props.user_type("client");
                setError('');
            }
          }
        if (email === 'abc@gmail' && password === '1234') {
            console.log("Login Success");
            props.connection(true);
            props.user_type("admin");
            setError('');
        }
        else {
            if (props.connection===false) {
            setError('This account doesn\'t exist or incorrect password!');
            console.log(error);
            props.connection(false);
            }
        }
        console.log(props.userID);
    }
    
        return (
            <div className = "wrapper">
                <div className = "form-wrapper">
                    <h2> Log In </h2>
                    <Form className = "form">
                        <Form.Group className = "formfield" size = "lg" controlId = "email">
                        <Form.Label className = "label"> Email </Form.Label>
                        <Form.Control className = "input"
                            autoFocus
                            type = "email"
                            name = "email"
                            onChange = {handleChange}
                        />
                        </Form.Group>
                        <Form.Group className = "formfield" size = "lg" controlId = "password">
                        <Form.Label className = "label"> Password </Form.Label>
                        <Form.Control className = "input"
                            type = "password"
                            name = "password"
                            onChange = {handleChange}
                        />
                        </Form.Group>
                        {error.length > 0 && <span style = {{color: "red"}}> {error} </span>}
                        <div className = "submit">
                            <Button className = "button" onClick = {loginClicked} type = "submit" disabled = {!validateForm()}>
                                Login
                            </Button>
                            <Button className = "button" onClick = {() => props.onFormSwitch("register")} type = "submit">
                                Sign Up
                            </Button>
                        </div>
                    </Form>
                </div>
            </div>
        );
    
}