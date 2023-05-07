import React, { useState } from 'react';
import './App.css';
import Home from './components/Home';
import OffersBeach from './components/OffersBeach';
import OffersMountain from './components/OffersMountain';
import OffersCity from './components/OffersCity';
import LogIn from './components/LogIn';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Navbar from './components/Navbar';
import { FormLogIn } from './components/FormLogIn';
import { FormSignUp } from './components/FormSignUp';
import BlankPage from './components/BlankPage';
import Admin from './components/Admin';
import MyTravels from './components/MyTravels';

function App() {
	const [currentForm, setCurrentForm] = useState("login");
	const toggleForm = (formName) => {
		setCurrentForm(formName);
	}
	const [loginStatus, setLoginStatus] = useState(false);
	const toggleLoginStatus = (logState) => {
		setLoginStatus(logState);
	}
	const [userType, setUserType] = useState("");
	const toggleUserType = (user) => {
		setUserType(user);
	}
	const [userID, setUserID] = useState("");
	const toggleUserID = (ID) => {
		setUserID(ID);
	}

		return (
			<Router>
				<div>
					<Navbar toggleForm = {toggleForm}
							loginStatus = {loginStatus}
							toggleLoginStatus = {toggleLoginStatus}
							userType = {userType}
							toggleUserType = {toggleUserType}>
					</Navbar>
					<div className = "content">
						<Routes>
							<Route path = '/' exact element = {<Home />}></Route>
							<Route path = '/LogIn' element = {
								<LogIn currentForm = {currentForm}
									   toggleForm = {toggleForm}
									   loginStatus = {loginStatus}
									   toggleLoginStatus = {toggleLoginStatus}
									   toggleUserType = {toggleUserType}
									   userID = {userID}
									   toggleUserID = {toggleUserID}/>
							}>
							</Route>
							<Route path = '/FormLogIn' element = {<FormLogIn />}></Route>
							<Route path = '/FormSignUp' element = {<FormSignUp />}></Route>
							<Route path = '/BlankPage' element = {<BlankPage />}></Route>
							<Route path = '/MyTravels' element = {<MyTravels loginStatus = {loginStatus} userID = {userID} />}></Route>
							<Route path = '/Admin' element = {<Admin loginStatus = {loginStatus} />}></Route>
							<Route path = '/OffersBeach' element = {<OffersBeach userType = {userType} userID = {userID} />}></Route>
							<Route path = '/OffersMountain' element = {<OffersMountain userType = {userType} userID = {userID} />}></Route>
							<Route path = '/OffersCity' element = {<OffersCity userType = {userType} userID = {userID} />}></Route>
						</Routes>
					</div>
				</div>
			</Router>
		  );
}

export default App;
