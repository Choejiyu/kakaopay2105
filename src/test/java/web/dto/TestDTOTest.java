package web.dto;


import com.example.kakaopay2105.web.dto.TestDTO;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TestDTOTest{
    @Test
    public void 롬복_기능_테스트() {
        String name = "abc";
        int amount = 1000;
        TestDTO dto = new TestDTO(name, amount);

        // assertThat
        //      assertj라는 테스트 검증 라이브러리의 검증 메소드이다.
        //      검증하고자 하는 대상을 인자로 받고, 메소드 체이닝을 활용하여 isEqualTo 메소드를 이어서 사용할 수 있다.
        //       isEqualTo : a
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }

}