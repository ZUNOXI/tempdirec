import React, { Component } from 'react';
// import './App.css';

class Stock extends Component {
  constructor(props){
    super(props);
    this.state = {
      stock: {
        companies: [],
        date: null
      },
      currentCompany: undefined,
      comIndex: {
        index: undefined,
        type: undefined
      }
    }
  }

  componentDidMount() {
    fetch('api/')
      .then(res => res.json())
      .then(json => this.setState({stock: json})) 
  }
  
  newsHref(code) {
    return `http://finance.naver.com/item/news.nhn?code=${code}`
  }

  selectCompany = (item) => {
    this.setState({currentCompany: item})
  }

  showCompanyInfo = (company) => {
    return(
      <div>
        <h2>{company.name}</h2>
        <a target="_blank" href={`http://finance.naver.com/item/news.nhn?code=${company.code}`}>네이버 뉴스에서 보기(봇 필터링 안되어 있음)</a>
        <ul>
        {
          this.renderNewses(company.news)
        }
        </ul>
      </div>
    )
  }

  renderNewses(news) {
    return(
      news.map(news => 
        <div className="News-Row">
          <p className="News-Title">{news.title[0]}   <span className="News-Date">{news.pubDate[0]}</span></p>
          <p><a target="_blank" className="News-Link" href={news.link[0]}>{news.link[0]}</a></p>
          <p className="News-Desc">{news.description[0]}</p>
        </div>
      )
    )
  }

  render() {
    const currentCompany = this.state.currentCompany;
    const companies = this.state.stock.companies;
    const date = this.state.stock.date;
    return (
      <div className="App">
      <div className="Side Side-Left">
        <div className="Stock Stock-Left">
        <h1>★상한 주식★</h1>
        <ul>
        {
          companies.filter(item =>
            item.type === 'rise').map((item, id) =>
            <li className="Com-Name" onClick={(i) => this.selectCompany(item)}>
              <span>■ {item.name} </span>
              <span class="Com-Rate-Rise">(↑{item.rate})</span>
            </li>
            )
        }
        </ul>
        </div>
        <div className="Stock Stock-Right">
        <h1>★하한 주식★</h1>
        {
          companies.filter(item =>
            item.type === 'fall').map(item => 
              <li className="Com-Name" onClick={(i) => this.selectCompany(item)}>
              <span>■ {item.name} </span>
              <span class="Com-Rate-Fall">(↓{item.rate})</span>
            </li>
            )
        }
        </div>
      </div>
      <div className="Side Side-Right">
      {
        currentCompany ? 
          this.showCompanyInfo(currentCompany) : ''
      }
      </div>
      </div>
    );
  }
}

// export default Stock;
export default Stock;