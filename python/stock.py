import requests
from bs4 import BeautifulSoup
import pymysql
conn = pymysql.connect(host='localhost',port=3306,user='root', password='ssafy',
                       db='javer', charset='utf8')
curs = conn.cursor()



# company_code를 입력받아 bs_obj를 출력
def get_bs_obj(company_code):
    url = "https://finance.naver.com/item/main.nhn?code="+ company_code
    result = requests.get(url)
    bs_obj = BeautifulSoup(result.content, "html.parser")
    return bs_obj


# company_code를 입력받아 now_price를 출력
def get_price(company_code):
    bs_obj = get_bs_obj(company_code)

    company_name = bs_obj.find("div",{"class":"wrap_company"})
    company_name_h2 = company_name.find("h2")
    co_name = company_name_h2.text



    no_today = bs_obj.find("p", {"class": "no_today"})
    blind = no_today.find("span", {"class": "blind"})
    now_price = blind.text

    # close 종가(전일)
    td_first = bs_obj.find("td", {"class": "first"})  # 태그 td, 속성값 first 찾기
    blind = td_first.find("span", {"class": "blind"})  # 태그 span, 속성값 blind 찾기
    close = blind.text

    # high 고가
    table = bs_obj.find("table", {"class": "no_info"})  # 태그 table, 속성값 no_info 찾기
    trs = table.find_all("tr")  # tr을 list로 []
    first_tr = trs[0]  # 첫 번째 tr 지정
    tds = first_tr.find_all("td")  # 첫 번째 tr 안에서 td를 list로
    second_tds = tds[1]  # 두 번째 td 지정
    high = second_tds.find("span", {"class": "blind"}).text

    # open 시가
    second_tr = trs[1]  # 두 번째 tr 지정
    tds_second_tr = second_tr.find_all("td")  # 두 번째 tr 안에서 td를 list로
    first_td_in_second_tr = tds_second_tr[0]  # 첫 번째 td 지정
    open = first_td_in_second_tr.find("span", {"class": "blind"}).text
    
    # low 저가
    second_td_in_second_tr = tds_second_tr[1]  # 두 번째 td 지정
    low = second_td_in_second_tr.find("span", {"class": "blind"}).text

    sql = "insert into stock(name,now,close,high,open,low) values(%s,%s,%s,%s,%s,%s)"
    curs.execute(sql,(co_name,now_price,close,high,open,low))

    return co_name, now_price, close, high, open, low

"""
셀트리온헬스케어 091990 / 에이치 엘비 028300 / CJ ENM 035760 / 스튜디오드래곤 253450 / 펄어비스 263750
케이엠더블유 032500 / 메디톡스 086900 / 휴젤 145020 / 원익IPS 240810 / 헬릭스미스 084990 /솔브레인036830 /SK머티리얼즈036490 /파라다이스034230
메지온140410 / 에스에프에이056190 / 아이티엠반도체084850 / 셀트리온제약068760 / 에코프로비엠247540 / 컴투스078340 / 젬백스082270

"""

company_codes = ["091990", "028300", "035760", "253450", "263750", "032500" ,"086900", "145020" ,"240810", "084990","036830","036490","034230","140410","056190","084850","068760","247540","078340","082270"]


# 출력은 회사명, 주식,종가,고가,시가,저가 순으로 출력
for item in company_codes:
    now_price = get_price(item)
    print(now_price)
conn.commit()
conn.close()