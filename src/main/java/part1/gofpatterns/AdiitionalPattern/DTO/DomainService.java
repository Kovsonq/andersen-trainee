package part1.gofpatterns.AdiitionalPattern.DTO;

public class DomainService {
    public DomainObjectDTO getData(){
        //assume backend service
        DomainObject object = getObject();
        DomainObjectDTO domainObjectDTO = new DomainObjectDTO();

        domainObjectDTO.seteProperty(object.geteProperty());

        return domainObjectDTO;
    }

    public DomainObject getObject(){
        return new DomainObject();
    }
}
