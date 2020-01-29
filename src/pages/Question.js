import React from "react";
import Board from "../components/Board";
import { Grid, Button } from "@material-ui/core";
import qa from "../images/Q&A2.png";

const Question = () => {
  const datas = [
    {
      id: 1,
      title: "재테크 추천 좀 해주세요!",
      content: "사회 초년생인데 할만한 재테크 없을까요?",
      like: 0,
      view: 0,
      date: 191231
    },
    {
      id: 2,
      title: "여기 머하는 곳임?",
      content: "재테크로 돈 많이 범?",
      like: 0,
      view: 0,
      date: 200101
    },
    {
      id: 3,
      title: "어떻게 해야할까",
      content: "지금 주식이랑 코인중에 어디에 투자할지 고민중입니다",
      like: 0,
      view: 0,
      date: 200121
    }
  ];
  return (
    <Grid container style={{ marginTop: "10px" }}>
      <h1>묻고 답하기</h1>
      <Grid
        item
        xs={12}
        container
        direction="row"
        justify="space-around"
        alignItems="center"
        style={{
          border: "1px solid #c8d0d0",
          borderRadius: "5px",
          marginTop: "5px",
          height: "5rem"
        }}
      >
        <Grid item xs={7} container direction="row" alignItems="center">
          <img src={qa} alt="" height="70px" />
          <h2>궁금한 것을 질문해 보세요!</h2>
        </Grid>
        <Grid item>
          <Button variant="contained" color="primary" href="/createquestion">
            질문하기
          </Button>
        </Grid>
      </Grid>
      <Grid item xs={12} style={{ marginTop: "10px", marginBottom: "5px" }}>
        <hr />
      </Grid>
      <Grid item xs={9}>
        {datas.map(data => (
          <Board one={data} />
        ))}
      </Grid>
      <Grid item xs={3}></Grid>
    </Grid>
  );
};

export default Question;
