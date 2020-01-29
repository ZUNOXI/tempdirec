import React, { useState, useEffect } from "react";
import axios from "axios";
import { makeStyles } from "@material-ui/core/styles";
import Table from "@material-ui/core/Table";
import TableBody from "@material-ui/core/TableBody";
import TableCell from "@material-ui/core/TableCell";
import TableContainer from "@material-ui/core/TableContainer";
import TableHead from "@material-ui/core/TableHead";
import TableRow from "@material-ui/core/TableRow";
import Paper from "@material-ui/core/Paper";
import { Divider } from "@material-ui/core";

const useStyles = makeStyles({
  table: {
    minWidth: 650
  }
});

const Coindata = () => {
  const [rows, setRows] = useState([]);
  useEffect(() => {
    axios
      .post("https://api.bithumb.com/public/ticker/ALL")
      .then(res => {
        const all_rows = [];
        for (let [key, value] of Object.entries(res.data.data)) {
          all_rows.push({
            name: key,
            opening_price: value.opening_price,
            acc_trade_value: value.acc_trade_value,
            fluctate_24H: value.fluctate_24H,
            fluctate_rate_24H: value.fluctate_rate_24H
          });
        }
        setRows(all_rows);
      })
      .catch(e => console.log(e));
  }, []);

  return <DenseTable rows={rows} />;
};

// function createData(name, acc_trade_value, fluctate_24H, fluctate_rate_24H) {
//   return { name, acc_trade_value, fluctate_24H, fluctate_rate_24H};
// }

const DenseTable = ({ rows }) => {
  const classes = useStyles();
  console.log(rows);
  return (
    <div>
      <p>🔥오늘의 비트코인🔥</p>
      <TableContainer component={Paper}>
        <Table
          className={classes.table}
          size="small"
          aria-label="a dense table"
        >
          <TableHead>
            <TableRow>
              <TableCell>순위</TableCell>
              <TableCell align="right">이름</TableCell>
              <TableCell align="right">시가</TableCell>
              <TableCell align="right">변동가</TableCell>
              <TableCell align="right">변동률</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {rows.map((row, idx) => (
              <TableRow key={row.name}>
                <TableCell component="th" scope="data">
                  {idx}
                </TableCell>
                <TableCell align="right">{row.name}</TableCell>
                <TableCell align="right">{row.opening_price}</TableCell>
                <TableCell align="right">{row.fluctate_24H}</TableCell>
                <TableCell align="right">{row.fluctate_rate_24H}</TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </div>
  );
};

export default Coindata;
