import React from "react";
import { Grid, Button } from "@material-ui/core";
import TextField from "@material-ui/core/TextField";
import questionicon from "../images/questionicon.png";
import Tabs from "@material-ui/core/Tabs";
import Tab from "@material-ui/core/Tab";
import AppBar from "@material-ui/core/AppBar";
import axios from "axios";
// import { withStyles } from "@material-ui/core/styles";

function a11yProps(index) {
  return {
    id: `simple-tab-${index}`
  };
}

const saveQuestion = datas => {
  console.log(datas);
  const url = "";
  axios.post(url, datas);
};

const CreateQuestion = () => {
  const [value, setValue] = React.useState(0);
  const handleChange = (event, newValue) => {
    setValue(newValue);
  };

  return (
    <form onSubmit={saveQuestion}>
      <Grid
        container
        direction="column"
        justify="flex-start"
        alignItems="center"
      >
        <Grid
          container
          direction="row"
          justify="space-around"
          alignItems="center"
          style={{ width: "100%", marginTop: "30px" }}
        >
          <img src={questionicon} alt="" style={{ height: "55px" }} />
          <h1>질문</h1>
          <TextField
            id="title"
            name="title"
            label="제목"
            variant="outlined"
            style={{ width: "80%" }}
          />
        </Grid>
        <Grid>
          <AppBar position="static">
            <Tabs value={value} onChange={handleChange}>
              <Tab label="주식" {...a11yProps(0)} />
              <Tab label="부동산" {...a11yProps(1)} />
              <Tab label="펀드" {...a11yProps(2)} />
              <Tab label="코인" {...a11yProps(3)} />
              <Tab label="기타" {...a11yProps(4)} />
            </Tabs>
          </AppBar>
        </Grid>
        <Grid style={{ width: "100%", marginTop: "10px" }}>
          <TextField
            id="content"
            name="content"
            label="내용"
            variant="outlined"
            multiline
            rows="20"
            style={{ width: "100%" }}
          />
        </Grid>
        <Grid container justify="flex-end" style={{ marginTop: "20px" }}>
          <Button variant="contained" color="primary" type="submit">
            제출
          </Button>
        </Grid>
      </Grid>
    </form>
  );
};

export default CreateQuestion;
