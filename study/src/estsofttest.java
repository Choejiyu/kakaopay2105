public class estsofttest {
    public int[] solution(String[] card_numbers) {
        int sum = 0;
        int add = 0;
        int result =0;
        boolean a = false;
        int[] answer = new int[card_numbers.length];
        for(int i= 0; i<card_numbers.length; i++){
            //int result2=1;
            //System.out.println(card_numbers[i]);
            //answer = new int[card_numbers.length];
            String card = card_numbers[i];
            System.out.println(card);
           String reg = "(\\d{4})[-](\\d{4})[-](\\d{4})[-](\\d{4})";
            String reg2 = "(\\d{4})(\\d{4})(\\d{4})(\\d{4})";
            if (card.matches(reg)||card.matches(reg2)) {
                card = card.replace("-", "");
                System.out.println("card: " + card);
                for (int j = card.length() - 1; j >= 0; j--) {
                    int number = Integer.parseInt(card.substring(j, j + 1));
                    if (a) {
                        add = number * 2;
                        if (add > 9) {
                            //add -= 9;
                            int sum2 =0;
                            while(add!=0){
                                //num을 10으로 나눈 나머지를 sum에 더한다.
                                sum2 += add%10;
                                //num을 10으로 나눈 값을 다시 num에 저장한다.
                                add /= 10;
                            }
                            add = sum2;
                        }
                    } else {
                        add = number;
                    }
                    sum += add;
                    a = !a;
                }
                result = sum % 10;
                if (result == 0) {
                    //result2=1;
                    answer[i] = 1;
                } else {
                    // result2=0;
                    answer[i] = 0;
                }
                // System.out.println(result2 + "-" + i);
            }else {
                System.out.println("false");
                answer[i] = 0;
             }
        }
        System.out.println(answer.length);
        for(int i= 0; i<answer.length; i++){
            System.out.println(answer[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
    estsofttest es= new estsofttest();

    String card[] = {"3285-3764-9934-2453", "3285376499342453", "3285-3764-99342453", "328537649934245", "3285376499342459", "3285-3764-9934-2452"};
    es.solution(card);
    }
}