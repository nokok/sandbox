import React from 'react';
import LoginScreen from './screens/LoginScreen';
import HomeScreen from "./screens/HomeScreen";
import {createStackNavigator} from 'react-navigation';

const RootStack = createStackNavigator({
  Home: HomeScreen,
  Login: LoginScreen
}, {
  initialRouteName: 'Home'
})

export default class App extends React.Component {
  render() {
    return (
      <RootStack/>
    );
  }
}