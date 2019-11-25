package xavier.blanc.ddd.presentation.DDDPRES;


import java.util.Objects;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
class Player  {
    private String nickName;

    Player(String nickName) {
        if (nickName == null) {
            throw new IllegalArgumentException("nickName cannot be null");
        }
        this.nickName = nickName;
    }

    public String NickName() {
        return nickName;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Player)) {
            return false;
        } else {
            Player otherPlayer = (Player) other;
            boolean equals = nickName.compareTo(otherPlayer.nickName) == 0;
            return equals;
        }
    }

    

    
}