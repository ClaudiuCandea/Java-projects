import React, { useState } from "react";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import './Form.css';

const RegexUserName = RegExp(/^[A-Za-z][A-Za-z0-9_-]/);
const RegexEmail = RegExp(/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/);

export const FormSignUp = (props) => {
    const [firstname, setFirstName] = useState('');
    const [lastname, setLastName] = useState('');
    const [country, setCountry] = useState('');
    const [city, setCity] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [ errorFirstName, setErrorFirstName ] = useState('');
    const [ errorLastName, setErrorLastName ] = useState('');
    const [ errorEmail, setErrorEmail ] = useState('');
    const [ errorPassword, setErrorPassword ] = useState('');

    function handleChange(e) {
        e.preventDefault();
        const { name, value } = e.target;
        switch (name) {
            case 'firstname':
                setFirstName(value);
                setErrorFirstName(RegexUserName.test(value) ? '' : 'First Name must start with a character and must contain only letters, numbers and/or "-" and "_"!');
                break;
            case 'lastname':
                setLastName(value);
                setErrorLastName(RegexUserName.test(value) ? '' : 'Last Name must start with a character and must contain only letters, numbers and/or "-" and "_"!');
                break;
            case 'country':
                setCountry(value);
                break;
            case 'city':
                setCity(value);
                break;
            case 'email':
                setEmail(value);
                setErrorEmail(RegexEmail.test(value) ? '' : 'Email is not valid!');
                break;
            case 'password':
                setPassword(value);
                setErrorPassword(value.length < 8 ? 'Password must be eight characters long!' : '');
                break;
            default:
                break;
        }
    }

   async function handleSubmit(e) {
        e.preventDefault();
        let validity = true;
        if (validity === true) {
            console.log("Registering can be done");
            props.user_type("client");
            props.connection(true);
            await fetch('api/v1/user/save', {
                method:'POST',
                headers: {
                  'Accept': 'application/json',
                  'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    firstname: firstname, 
                    lastname: lastname,
                    country : country ,
                    city: city,
                    email: email,
                    password:password,
                type: "client"})
            });
        }
        else {
            console.log("You cannot be registered!!!")
        }
    }
        return (
            <div className = 'wrapper'>
                <div className = 'form-wrapper'>
                    <h2>Sign Up</h2>
                    <Form className = "form" onSubmit = {handleSubmit}>
                        <div className = 'firstname'>
                            <label htmlFor = "firstname"> First Name </label>
                            <input type = 'firstname' name = 'firstname' onChange = {handleChange}/>
                            {errorFirstName.length >= 0 && <span style = {{color: "red"}}> {errorFirstName} </span>}
                        </div>
                        <div className = 'lastname'>
                            <label htmlFor = "lastname"> Last Name </label>
                            <input type = 'lastname' name = 'lastname' onChange = {handleChange}/>
                            {errorLastName.length >= 0 && <span style = {{color: "red"}}> {errorLastName} </span>}
                        </div>
                        <div className = 'country'>
                            <label htmlFor = "country"> Country </label>
                            <input type = 'country' name = 'country' onChange = {handleChange}/>
                        </div>
                        <div className = 'city'>
                            <label htmlFor = "city"> City/Residence </label>
                            <input type = 'city' name = 'city' onChange = {handleChange}/>
                        </div>
                        <div className = 'email'>
                            <label htmlFor = "email"> Email </label>
                            <input type = 'email' name = 'email' onChange = {handleChange}/>
                            {errorEmail.length >= 0 && <span style = {{color: "red"}}> {errorEmail} </span>}
                        </div>
                        <div className = 'password'>
                            <label htmlFor = "password"> Password </label>
                            <input type = 'password' name = 'password' onChange = {handleChange}/>
                            {errorPassword.length >= 0 && <span style = {{color: "red"}}> {errorPassword} </span>}
                        </div>
                        <div className = 'submit'>
                            <Button className = "button" type = "submit">
                                Register Me
                            </Button>
                        </div>
                        <div className = 'submit'>
                            <Button className = "button" onClick = {() => props.onFormSwitch("login")}>
                                Back To LogIn
                            </Button>
                        </div>
                    </Form>
                </div>
            </div>
        );
}