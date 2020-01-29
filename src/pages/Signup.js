import React, { useState } from "react";
import Input from "@material-ui/core/Input";
import FormLabel from "@material-ui/core/FormLabel";
import { Grid } from "@material-ui/core";
import axios from "axios";

const Signup = () => {
  const [id, setId] = useState("");
  const [name, setName] = useState("");
  const [nickname, setNickname] = useState("");
  const [phonenumber, setPhonenumber] = useState("");
  const [email, setEmail] = useState("");
  const [address, setAddress] = useState("");
  const [favor_ctg, setFavor_ctg] = useState("");
  const [photo, setPhoto] = useState("");
  const [birth_date, setBirth_date] = useState("");
  const [password, setPassword] = useState("");
  const [confirm, setConfirm] = useState("");

  const setIdText = e => {
    setId(e.target.value);
  };

  const setNameText = e => {
    setName(e.target.value);
  };

  const setNicknameText = e => {
    setNickname(e.target.value);
  };

  const setPhonenumberText = e => {
    setPhonenumber(e.target.value);
  };

  const setEmailText = e => {
    setEmail(e.target.value);
  };

  const setAddressText = e => {
    setAddress(e.target.value);
  };

  const setFavor_ctgText = e => {
    setFavor_ctg(e.target.value);
  };

  const setPhotoText = e => {
    setPhoto(e.target.value);
  };

  const setBirth_dateText = e => {
    setBirth_date(e.target.value);
  };

  const setPasswordText = e => {
    setPassword(e.target.value);
  };

  const setConfirmText = e => {
    setConfirm(e.target.value);
  };

  const save = e => {
    e.preventDefault();
    const URL = "http://localhost:9090/rest/addMem";
    console.log(confirm);
    const data = {
      uid: id,
      upw: password,
      uname: name,
      unickname: nickname,
      uphonenum: phonenumber,
      uemail: email,
      uaddress: address,
      ufavor_ctg: favor_ctg,
      uprofilephoto: photo,
      ubirth_date: birth_date
    };
    console.log(data);
    axios
      .post(URL, data)
      .then(res => {
        console.log(res);
      })
      .catch(e => console.log(e));
  };

  return (
    <form onSubmit={save}>
      <Grid
        container
        direction="column"
        justify="flex-start"
        alignItems="center"
      >
        <h1 style={{ color: "blue" }}>JAVER</h1>
        <FormLabel htmlFor="id">아이디</FormLabel>
        <Input name="id" id="id" onChange={setIdText} />
        <br />
        <FormLabel htmlFor="password">비밀번호</FormLabel>
        <Input name="password" id="password" onChange={setPasswordText} />
        <br />
        <FormLabel htmlFor="confirm">비밀번호 재확인</FormLabel>
        <Input name="confirm" id="confirm" onChange={setConfirmText} />
        <br />
        <FormLabel htmlFor="name">이름</FormLabel>
        <Input name="name" id="name" onChange={setNameText} />
        <br />
        <FormLabel htmlFor="name">별명</FormLabel>
        <Input name="nickname" id="nickname" onChange={setNicknameText} />
        <br />
        <FormLabel htmlFor="phonenumber">핸드폰</FormLabel>
        <Input
          name="phonenumber"
          id="phonenumber"
          onChange={setPhonenumberText}
        />
        <br />
        <FormLabel htmlFor="email">이메일</FormLabel>
        <Input name="email" id="email" onChange={setEmailText} />
        <br />
        <FormLabel htmlFor="address">주소</FormLabel>
        <Input name="address" id="address" onChange={setAddressText} />
        <br />
        <FormLabel htmlFor="favor_ctg">선호분야</FormLabel>
        <Input name="favor_ctg" id="favor_ctg" onChange={setFavor_ctgText} />
        <br />
        <FormLabel htmlFor="photo">프로필사진</FormLabel>
        <Input name="photo" id="photo" onChange={setPhotoText} />
        <br />
        <FormLabel htmlFor="birth_date">생년월일</FormLabel>
        <Input name="birth_date" id="birth_date" onChange={setBirth_dateText} />
        <br />
        <Input type="submit" value="제출" />
      </Grid>
    </form>
  );
};

export default Signup;
