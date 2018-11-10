import React from 'react';
import {Image, Text, TextInput} from "react-native";

const BrandLogo = (props) => {
  return (
    <Image
      style={{width: props.width || 50, height: props.height || 50}}
      source={{uri: 'https://facebook.github.io/react-native/docs/assets/favicon.png'}}
      {...props}
    />
  );
};

const EmailInput = (props) => {
  return (
    <TextInput
      placeholder={(props.placeholder || 'メールアドレスを入力してください')}
      keyboardType="email-address"
      {...props}
    />
  );
};

const TitleText = (props) => {
  return (
    <Text
      style={{fontWeight: "bold"}}
      {...props}
    >{props.text}
    </Text>
  );
};


export {
  BrandLogo,
  EmailInput,
  TitleText
};