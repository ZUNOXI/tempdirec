import React from "react";
import { Grid } from "@material-ui/core";
const Estate = () => {
  return (
    <Grid container direction="column" justify="flex-start" alignItems="center">
      <Grid
        item
        style={{ backgroundColor: "blue", width: "100%", height: "30rem" }}
      >
        지도 api
      </Grid>
      <Grid
        item
        style={{
          backgroundColor: "black",
          width: "100%",
          height: "50rem"
        }}
      >
        세부사항
      </Grid>
    </Grid>
  );
};

export default Estate;
