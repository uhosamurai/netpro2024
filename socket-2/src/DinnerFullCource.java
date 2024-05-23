public class DinnerFullCource {
    private Dish[] list = new Dish[5];// [0]-[4]の計5個

	public static void main(String[] args) {

		DinnerFullCource fullcourse = new DinnerFullCource();
        fullcourse.setAll();
		fullcourse.eatAll();
	}

    public DinnerFullCource(){
        list[0]=new Dish();
        list[1]=new Dish();
        list[2]=new Dish();
        list[3]=new Dish();
        list[4]=new Dish();
    }


    public void setAll(){
        list[0].setName("うどん");
        list[0].setValune(500);
        list[1].setName("ラーメン");
        list[1].setValune(700);
        list[2].setName("博多の塩");
        list[2].setValune(100);
        list[3].setName("カレー");
        list[3].setValune(600);
        list[4].setName("焼肉");
        list[4].setValune(3000);
    }

    public void eatAll(){
        for(Dish dish:list){
          System.out.println("料理の名前 "+dish.getName()+"  "+"値段 "+dish.getValune()+"円");
        }
    }
}
    
        
    

