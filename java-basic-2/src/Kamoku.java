public class Kamoku implements Comparable<Kamoku>{
    String name;
	int score;
	private int studentid;

	Kamoku(int s,int id) {  // これがコンストラクタ。特殊なメソッド。クラス名と同じ。
		score = s; 
		studentid=id;
	}

// setScore というメソッドを定義する。
// score に値を設定する。
	public void setScore(int num){
		score = num;
	}

// getScore というメソッドを定義する。
// scoreを返す。
	public int getScore() {
		return score;
	}

	public int getStudentid(){
return studentid;
	}

	public int compareTo(Kamoku other) {
        return Integer.compare(this.score, other.score);
    }


// メソッド 関数のこと  
//   public 返り値(戻り値return value) 関数名() {
//      中に具体的な処理を書く
public String TOString(){
 return "学籍番号"+getStudentid()+" "+ "得点" +getScore();

 }
}
