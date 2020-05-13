package ourplugin.generator.util;

import ourplugin.generator.BaseRepositoryGenerator;
import ourplugin.generator.BaseRepositoryImplGenerator;
import ourplugin.generator.BasicGenerator;
import ourplugin.generator.ControllerAbstractGenerator;
import ourplugin.generator.ControllerGenerator;
import ourplugin.generator.ConverterDtoToEntityGenerator;
import ourplugin.generator.ConverterEntityToDtoGenerator;
import ourplugin.generator.DtoGenerator;
import ourplugin.generator.EJBGenerator;
import ourplugin.generator.EntityGenerator;
import ourplugin.generator.MainGenerator;
import ourplugin.generator.RepositoryGenerator;
import ourplugin.generator.ServiceAbstractGenerator;
import ourplugin.generator.ServiceGenerator;
import ourplugin.generator.ServiceImplGenerator;
import ourplugin.generator.options.GeneratorOptions;

public class GeneratorFactory {
	
	public enum GeneratorType {
		EJBGenerator,
		EntityGenerator, 
		RepositoryGenerator,
		BaseRepositoryGenerator,
		BaseRepositoryImplGenerator,
		MainGenerator,
		ControllerAbstractGenerator,
		ControllerGenerator,
		ServiceGenerator,
		ServiceAbstractGenerator,
		ServiceImplGenerator,
		DtoGenerator,
		ConverterEntityToDtoGenerator,
		ConverterDtoToEntityGenerator,
	}

	public static BasicGenerator getGenerator(GeneratorOptions generatorOptions) {
		GeneratorType generatorType = null;
		try {
			generatorType = GeneratorType.valueOf(generatorOptions.getGeneratorName());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			throw new NoGeneratorException("Could not find requested generator");
		}
		
		switch (generatorType) {
			case EJBGenerator:
				return new EJBGenerator(generatorOptions);
			case EntityGenerator:
				return new EntityGenerator(generatorOptions);
			case RepositoryGenerator:
				return new RepositoryGenerator(generatorOptions);
			case BaseRepositoryGenerator:
				return new BaseRepositoryGenerator(generatorOptions);
			case BaseRepositoryImplGenerator:
				return new BaseRepositoryImplGenerator(generatorOptions);
			case MainGenerator:
				return new MainGenerator(generatorOptions);
			case ControllerAbstractGenerator:
				return new ControllerAbstractGenerator(generatorOptions);
			case ControllerGenerator:
				return new ControllerGenerator(generatorOptions);
			case ServiceGenerator:
				return new ServiceGenerator(generatorOptions);
			case ServiceAbstractGenerator:
				return new ServiceAbstractGenerator(generatorOptions);
			case ServiceImplGenerator:
				return new ServiceImplGenerator(generatorOptions);
			case DtoGenerator:
				return new DtoGenerator(generatorOptions);
			case ConverterDtoToEntityGenerator:
				return new ConverterDtoToEntityGenerator(generatorOptions);
			case ConverterEntityToDtoGenerator:
				return new ConverterEntityToDtoGenerator(generatorOptions);
			default: 
				return new EJBGenerator(generatorOptions);
		}
	}
}
