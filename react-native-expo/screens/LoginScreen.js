import React from 'react';
import {StyleSheet, View, Button} from 'react-native';
import {TitleText, BrandLogo, EmailInput} from "../components/base-ui";
import emailValidator from 'email-validator';

class LoginScreen extends React.Component {
  static navigationOptions = {
    header: null
  };

  constructor(props) {
    super(props);
    this.state = {loginEmail: ''};
  }

  render() {
    const {navigate} = this.props.navigation;
    return (
      <View style={style.container}>
        <BrandLogo/>
        <TitleText text={"ログイン"}/>
        <View style={{borderColor: 'red'}}>
          <EmailInput
            style={{height: 40}}
            onChangeText={(text) => {
              if (emailValidator.validate(text)) {
              }
              this.setState({loginEmail: text})
            }}
          />
          <Button
            title="ログイン"
            style={{width: 120}}
            onPress={() => {
              if (this.state.loginEmail === '') {
                alert("メールアドレスを入力してください");
                return;
              }
              if (emailValidator.validate(this.state.loginEmail)) {
                navigate('Home', {})
              } else {
                alert("メールアドレスを正しく入力してください")
              }
            }}
          />
        </View>
      </View>
    );
  }
};

const style = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center'
  }
});

export default LoginScreen;