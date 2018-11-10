import React from 'react';
import {View, Text, StyleSheet} from 'react-native';
import {createStackNavigator} from 'react-navigation';

class HomeScreen extends React.Component {
  static navigationOptions = {
    header: null
  };

  constructor(props) {
    super(props);
  }

  render() {
    return (
      <View style={style.container}>
        <Text>Home</Text>
      </View>
    );
  }
}

export default createStackNavigator({
  Home: HomeScreen
})


const style = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center'
  }
});
