package edu.cornell.cals.biomat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(scanBasePackages = {"edu.cornell"})
@EnableJpaAuditing
public class BiomaterialsApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BiomaterialsApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(BiomaterialsApplication.class, args);
    }
}

/*


 		<div class='row' >
			<div class='col-sm-1'>&nbsp;</div>
			<div class='col-sm-2 text-info'><b>Material Composition </b></div>
			<div class='col-sm-2 text-info'><b>Unit</b></div>
			<div class='col-sm-2 text-info'><b>USDA Value</b> </div>
			<div class='col-sm-2 text-info'><b>Your Value(Optional)</b></div>
		</div>



 		<div class='form-group row'>
			<form:input type='hidden' value = '${bioMaterialNutrientModelList[0].bioMaterialId}' id='bioMaterialNutrientModelList[0].bioMaterialId' path='bioMaterialNutrientModelList[0].bioMaterialId'/>
			<form:input type='hidden' value = '${bioMaterialNutrientModelList[0].bioNutrientId}' id='bioMaterialNutrientModelList[0].bioNutrientId' path='bioMaterialNutrientModelList[0].bioNutrientId'/>
			<form:input type='hidden' value = '${bioMaterialNutrientModelList[0].nutrientName}' id='bioMaterialNutrientModelList[0].nutrientName' path='bioMaterialNutrientModelList[0].nutrientName'/>
			<form:input type='hidden' value = '${bioMaterialNutrientModelList[0].nutrientUnit}' id='bioMaterialNutrientModelList[0].nutrientUnit' path='bioMaterialNutrientModelList[0].nutrientUnit'/>
			<form:input type='hidden' value = '${bioMaterialNutrientModelList[0].nutrientSymbol}' id='bioMaterialNutrientModelList[0].nutrientSymbol' path='bioMaterialNutrientModelList[0].nutrientSymbol'/>

			<div class='col-sm-1'>&nbsp;</div>
			<div class='col-sm-2 text-info'>Protein</div>
			<div class='col-sm-2 text-info'>%</div>
			<div class='col-sm-2 text-info'>10</div>
			<div class='col-sm-2'>
				<form:input class='form-control' id='bioMaterialNutrientModelList[0].userValue' path='bioMaterialNutrientModelList[0].userValue' />
			</div>

		</div>



 */
