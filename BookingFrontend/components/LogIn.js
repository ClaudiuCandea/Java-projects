import { Navigate } from "react-router";
import { FormLogIn } from "./FormLogIn";
import { FormSignUp } from "./FormSignUp";

export default function LogIn(props) {
    const { currentForm, toggleForm, loginStatus, toggleLoginStatus, toggleUserType, userID, toggleUserID } = props;

    if (loginStatus === true) {
        return <Navigate to = "/" />
    }

    return(
        currentForm === "login" ?
            <FormLogIn onFormSwitch = {toggleForm}
                       connection = {toggleLoginStatus}
                       user_type = {toggleUserType}
                       userID = {userID}
                       toggleUserID = {toggleUserID}/>
        :
        <FormSignUp onFormSwitch = {toggleForm}
                    connection = {toggleLoginStatus}
                    user_type = {toggleUserType}
                    toggleUserID = {toggleUserID}/>
    );
}