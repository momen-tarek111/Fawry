package SuperMarket;

import java.time.LocalDate;
import java.util.Date;

public class Expirable implements IExpirable{
    private LocalDate expirtionDate;
    public Expirable(LocalDate date){
        this.expirtionDate=date;
    }
    @Override
    public boolean isExpired(){
        return LocalDate.now().isAfter(expirtionDate);
    }
    public LocalDate getExpirtionDate(){
        return this.expirtionDate;
    }

}
