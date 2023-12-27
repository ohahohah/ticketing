# ticketing-system
- 뮤지컬, 연극 공연 예매 시스템
## 기능
- API : https://docs.google.com/spreadsheets/d/1y6MqM78p1544qiUpwz9o1BW-rQlkDv3PrBGcdkSEQDc/edit#gid=0
### FE
- **[MVP] 공연 예매 (자리 포함) **
    - 제약 조건 : ...., 동시성 고려
- 공연 예매 취소
- 회원별 예매내역 조회
- 공연 정보 조회 (일자별, 공연장별)
### Backoffice
- 공연 정보 등록/수정/삭제
### 추가 기능 (optional)
- 공연 검색어 자동완성
- 관심 공연 오픈시 이메일/sms 알림
- 공연 굿즈 판매
- 실시간 인기 공연 차트

## 데이터 DB
- API 공연예술통합전산망 https://www.kopis.or.kr/
- DB dump - (historical)broadway show/theater http://theatredb.com/
- this week show https://www.broadwayworld.com/broadway-this-week.cfm
    - from. https://yaakovbressler.medium.com/opening-the-stage-door-for-big-data-in-broadway-20ca3e35a274

### Tool
- API 설계: swagger or spreadsheet
- API 문서 : Spring REST doc
- gradle (multi module)
