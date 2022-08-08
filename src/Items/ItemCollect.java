package Items;

import java.util.ArrayList;
//카테고리별 메뉴 정보
public class ItemCollect {
   
   public static String CategoryInformation;
   
   private static ArrayList<Item> Protein = new ArrayList<Item>(); 
   private static ArrayList<Item> Chicken = new ArrayList<Item>(); 
   private static ArrayList<Item> Salad = new ArrayList<Item>();
   private static ArrayList<Item> Snack = new ArrayList<Item>();
   
   //프로틴
   public static ArrayList<Item> getProtein() { 
      
      Item i1=new Item("프로바이오틱 웨이 프로틴",48900,
            "무게: 900g\r\n"
            + "맛 : 초콜릿\r\n"
            + "신체가 필요로 하는 고품질의 단백질을 제공"); 
      Item i2=new Item("THE 다이어트",84900,
            "무게 : 1500g\r\n"
            + "맛 : 딸기\r\n"
            + "체중 감량 프로그램, 건강한 생활방식 보완");
      Item i3=new Item("THE 게이너",129900,
            "무게 : 2500g\r\n"
            + "맛 : 초콜릿\r\n"
            + "체중 증량 프로그램, 건강한 생활방식 보완");
      Item i4=new Item("클리어 소이 프로틴",59900,
            "무게 : 800g\r\n"
            + "맛 : 레몬라임\r\n"
            + "분리 대두 단백과 과일 농축 함유");
      Item i5=new Item("소이+콜라겐 프로틴",84900,
             "무게 : 1500g\r\n"
            + "맛 : 밀크티\r\n"
            + "단백질과 비오틴을 비롯한 필수 비타민의 혼합");
      
      Protein.add(i1);
      Protein.add(i2);
      Protein.add(i3);
      Protein.add(i4);
      Protein.add(i5);
      
      return Protein;
   }
   
   //닭가슴살
   public static ArrayList<Item> getChicken() {
      
      Item i1=new Item("스팀 오리지널",1600,
                  "칼로리 : 110kcal\r\n"
                  + "단백질 : 24g함유\r\n"
                  + "기본에 충실한 단백한 오리지널 스팀 닭가슴살");
      Item i2=new Item("스팀 갈릭스파이시",1800,
                  "칼로리 : 110kcal\r\n"
                  + "단백질 : 22g함유\r\n"
                  + "스팀으로 푹 찐 갈릭향 스파이시 닭가슴살"); 
      Item i3=new Item("스팀 슬라이스 리얼갈릭",2100,
                  "칼로리 : 110kcal\r\n"
                  + "단백질 : 21g함유\r\n"
                  + "달달하고 부드러운 마늘의 깊곳 진한 닭가슴살");
      Item i4=new Item("큐브 숯불갈비맛",2200,
                   "칼로리 : 110kcal\r\n"
                    + "단백질 : 17g함유\r\n"
                    + "자극적이지 않은 단맛에 은은한 숯불 향"); 
      Item i5=new Item("더블함박 스테이크",2400,
                  "칼로리 : 110kcal\r\n"
                  + "단백질 : 15g함유\r\n"
                  + "구수한 맛과 입안 가득 퍼지는 부드러운 단 맛"); 
      
      Chicken.add(i1);
      Chicken.add(i2);
      Chicken.add(i3);
      Chicken.add(i4);
      Chicken.add(i5);

      return Chicken;
   }
   //샐러드
   public static ArrayList<Item> getSalad() {
         
      Item i1=new Item("그린 샐러드",2700,
               "칼로리 : 280kcal\r\n"
               + "채소종류 : 방울토마토, 케일, 양상추, 적근대 등\r\n"
               + "지구에서 신선한 그린은 모두 모은, 진짜 '풀파티!");
      Item i2=new Item("크래미아 베이컨 샐러드",5400,
                "칼로리 : 297kcal\r\n"
            + "채소종류 : 크래미아, 베이컨, 크루통, 오이 등\r\n"
            + "건강하게 짭조름한 맛을 느끼고 싶을 때");
      Item i3=new Item("리코타 과일 샐러드",5400,
                "칼로리 : 245kcal\r\n"
            + "채소종류 : 리코타치즈, 상큼한 과일 등\r\n"
            + "치즈의 풍미, 가볍게 와인 한 잔에 이 샐러드 어떨까요?");
      Item i4=new Item("머쉬룸 갈릭치킨 샐러드",5400,
               "칼로리 : 294kcal\r\n"
            + "채소종류 : 새송이버섯 구이, 갈릭치킨, 포두부 등\r\n"
            + "자연의 맛 그대로를 담은 쫀득한 새송이버섯"); 
      Item i5=new Item("쉬림프 크림 파스타 샐러드",8500,
               "칼로리 : 298kcal\r\n"
            + "채소종류 : 새우, 올리브, 할라피뇨, 펜네 등\r\n"
            + "펜네, 푸실래, 마카로니면을 골라먹는 재미!");
      
      Salad.add(i1);
      Salad.add(i2);
      Salad.add(i3);
      Salad.add(i4);
      Salad.add(i5);
      
      return Salad;
   }
   //스낵
   public static ArrayList<Item> getSnack() {
      
      Item i1=new Item("프로틴 브라우니",32900,
              "구성 : 12 * 75g\r\n"
            + "칼로리 : 287kcal\r\n"
            + "코코아를 가득 넣어 사르르 녹는 프로틴 브라우니"); 
      Item i2=new Item("프로틴 바",38900,
              "구성 : 12 * 65g\r\n"
            + "칼로리 : 222kcal\r\n"
            + "6겹의 놀라운 맛과 식감의 고단백 스낵.");
      Item i3=new Item("프로틴 쿠키",47900,
              "구성 : 12 * 75g\r\n"
            + "칼로리 : 321kcal\r\n"
            + "빠르게 단백질을 섭취를 도와주는 고단백질 쿠키"); 
      Item i4=new Item("넛츠 믹스",39900,
              "구성 : 12 * 20g\r\n"
            + "칼로리 : 92kcal\r\n"
            + "견과류와 에다마메 콩의 환상의 조합");  
      Item i5=new Item("프로틴 초콜릿 스프레드",36900,
              "구성 : 24 * 15g\r\n"
            + "칼로리 : 81kcal\r\n"
            + "밀크·화이트 초콜렛, 초콜렛 헤이즐넛 다양한 달콤함"); 
      
      Snack.add(i1);
      Snack.add(i2);
      Snack.add(i3);
      Snack.add(i4);
      Snack.add(i5);
      
      return Snack;
   }
   
   
   
}