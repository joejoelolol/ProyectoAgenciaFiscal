package Entidades;

import Entidades.Automovil;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-05-30T15:22:33", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Placa.class)
public class Placa_ { 

    public static volatile SingularAttribute<Placa, Automovil> numeroSerie;
    public static volatile SingularAttribute<Placa, String> estado;
    public static volatile SingularAttribute<Placa, String> tipoAuto;
    public static volatile SingularAttribute<Placa, String> idPlaca;
    public static volatile SingularAttribute<Placa, Date> fechaEmision;
    public static volatile SingularAttribute<Placa, Date> fechaRecepcion;

}