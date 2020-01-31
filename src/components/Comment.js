import React from "react";
import { Button, TextField } from "@material-ui/core";

const Comment = ({ data }) => {
  const showqmentel = exist => {
    if (exist) {
      return (
        <div>
          {exist.map(one => (
            <div key={one.id}>
              <b>
                <p style={{ fontSize: "15px" }}>{one.writer}</p>
              </b>
              <p style={{ fontSize: "10px" }}>{one.content}</p>
              <p style={{ fontSize: "10px" }}>{one.date}</p>
              <hr style={{ border: "0.5px solid #c8d0d0" }} />
            </div>
          ))}
        </div>
      );
    } else {
      return <div></div>;
    }
  };
  return (
    <div style={{ marginBottom: "20px" }}>
      <TextField
        multiline
        rows="1"
        variant="outlined"
        style={{
          backgroundColor: "#fafafa",
          width: "100%",
          marginBottom: "10px"
        }}
      />
      <div style={{ display: "flex", justifyContent: "flex-end" }}>
        <Button variant="contained" color="primary">
          등록
        </Button>
      </div>
      <div>{showqmentel(data)}</div>
    </div>
  );
};

export default Comment;
