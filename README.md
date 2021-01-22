## 고민한잔   대화형 익명 고민 나눔 서비스

### 동기 및 목적
- 2017년 기준 성인 10명 중 3명은 스트레스를 ‘대단히 많이’
또는 ‘많이’ 느끼고 있고 특히 20대가 취업, 학업, 진로 등의 이
유로 다른 연령층보다 스트레스인지율이 높음.
- 서비스를 통해 20대들이 부담과 거부감 없이 고민을 털어놓을
수 있는 일상 속의 피난처와 같은 역할을 제공, 비슷한 고민을
가진 20대들을 연결해주고 서로 소통하며 심리적인 위로를 얻
을 것으로 예상됨

### 사용자 관찰 및 분석
- 설문조사 : 응답 190명
- 인터뷰 : 대학생 4명, 취업준비생 2명, 직장인 2명
- 주요니즈추출 :
비슷한 고민과 감정을 가진 사람들과 고민을 나누기 원한다.
직접 제한 기능을 통해 건전한 사용자를 만날 수 있는 자유도를 얻기 원한다.
감정을 나타낼 수 있는 이모티콘
공감하기와 이해하기, 신뢰도
음악, 배경화면 등

### UCD 및 기대효과
- 음악 공유 : 음악을 공유하면서 심리적 안정감을 얻을 수 있음
- 공감 : 다른 사용자들의 공감 기능을 통해 위로를 얻을 수 있음
- 신뢰도 : 상대방의 신뢰성을 미리 알면 불안감이 줄어듦
- 제한 기능 : 희망하는 사용자끼리 대화할 수 있음
- 주제별 분류 : 원하는 고민을 선택해 사용성을 높임
- 감정 이모티콘 : 대면(서로 얼굴을 보며) 대화하는 효과를 줌

<img src = "https://user-images.githubusercontent.com/48430005/105446745-1a4d2a00-5cb6-11eb-891e-33301e848302.jpg" width="180px">

### 개발 환경
<img src = "https://user-images.githubusercontent.com/48430005/105446695-fe498880-5cb5-11eb-8ceb-685304ee6664.jpg" width="300px">

### 사용성 평가
- System Usability Scale의 10개 문항으로 사용성 측정.
고민한잔	90, 62.5, 70, 80, 72.5, 65, 87.5, 80, 90, 77.5, 92.5, 77.5, 80 평균78.8
오픈채팅	65, 55, 75, 80, 67.5, 65, 40, 47.5, 77.5, 82.5, 87.5, 60, 60 평균66.3

Python SciPy패키지로 t-test 결과 p-value=0.015, t-value=2.657, dof=24로 (유의수준5%)
사용성이 유의미하게 차이가 있다는 결과를 얻음.

### 단계별 GUI

<img src = "https://user-images.githubusercontent.com/48430005/105447433-8714f400-5cb7-11eb-92d8-0342e08f1dfb.jpg" width="200px">
<img src = "https://user-images.githubusercontent.com/48430005/105447436-88deb780-5cb7-11eb-904d-235e6d146bb9.jpg" width="200px">
<img src = "https://user-images.githubusercontent.com/48430005/105447438-8a0fe480-5cb7-11eb-9c11-b4fc76bdf626.jpg" width="200px">
<img src = "https://user-images.githubusercontent.com/48430005/105447441-8b411180-5cb7-11eb-9cce-948596957950.jpg" width="200px">
<img src = "https://user-images.githubusercontent.com/48430005/105447444-8da36b80-5cb7-11eb-85c5-8abf3002df79.jpg" width="200px">
<img src = "https://user-images.githubusercontent.com/48430005/105447448-8ed49880-5cb7-11eb-9681-3f92c7d2c234.jpg" width="200px">
<img src = "https://user-images.githubusercontent.com/48430005/105447452-909e5c00-5cb7-11eb-91a5-ad1e73a26280.jpg" width="200px">
<img src = "https://user-images.githubusercontent.com/48430005/105447456-9300b600-5cb7-11eb-8c12-c6947132182e.jpg" width="200px">

