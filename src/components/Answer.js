import React, { useState } from "react";
import MessageIcon from "@material-ui/icons/Message";
import styled from "styled-components";
import { Grid, Button, Icon, TextField } from "@material-ui/core";

const StyledIcon = styled(Icon)`
  margin-right: 20px;
  &:hover {
    cursor: pointer;
  }
`;

const Answer = data => {
  const [acbool, setAcbool] = useState(false);
  const acomment = () => {
    if (acbool) {
      setAcbool(false);
    } else {
      setAcbool(true);
    }
  };
  return (
    <div
      style={{
        width: "100%",
        border: "1px solid #c8d0d0",
        borderRadius: "5px",
        marginBottom: "20px"
      }}
    >
      <div style={{ marginLeft: "10%", marginRight: "5%" }}>
        <p>{data.data.writer}</p>
        <hr style={{ border: "0.5px solid #c8d0d0" }} />
        <p>{data.data.content}</p>
        <br />
        <hr style={{ border: "0.5px solid #c8d0d0" }} />
        <footer>
          <p style={{ fontSize: "12px" }}>{data.data.date}</p>
          <StyledIcon onClick={acomment} component={MessageIcon} />
        </footer>
      </div>
    </div>
  );
};

export default Answer;
