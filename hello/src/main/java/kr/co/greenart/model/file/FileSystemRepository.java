package kr.co.greenart.model.file;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class FileSystemRepository implements FileRepository {
	File saveFolder = new File("d:\\temp\\");

	@Override
	public Resource getByName(String fileName) {
		try {
			return new UrlResource(new File(saveFolder.getAbsolutePath() + File.separatorChar + fileName).toURI());
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<String> getAllnames() {
		File[] filearr = saveFolder.listFiles(new FileFilter() {

			@Override
			public boolean accept(File pathname) {
				return !pathname.isDirectory();
			}
		});
		List<String> list = new ArrayList<>();
		for (File f : filearr) {
			list.add(f.getName());
		}
		return list;

		// 또는
		// 함수가 참인 원소만 골라내짐
		// 자바는 함수를 인터페이스의 형태로 구현해야 가능하다
		// 람다식 (파라미터 -> 메소드 바디)
//      filter에 함수(람다식)를 사용하여 계속해서 걸러내서 원하는 값만 가져올 수 있다.
//      map은 stream에 있는 원소들을 매핑할 수 있음. 여기선 pathStream//
//      walk는 해당경로에 있는 것들을 다 가져옴(?)
//      자기 자신을 똑같이 반환해줌(??)
//		try {
//		return Files.walk(root, 1)
//			.filter(t -> !t.equals(root))
//			.filter(x -> !Files.isDirectory(x))
//			.map(y -> y.toString())
//			.collect(Collectors.toList());
//	} catch (IOException e) {
//		e.printStackTrace();
//	}
	}

	@Override
	public int save(MultipartFile file) {
		if (!saveFolder.exists()) {
			saveFolder.mkdir();
		}
		try {
			file.transferTo(new File(saveFolder.getAbsolutePath() + File.separatorChar + file.getOriginalFilename()));
			return 1;
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			return 0;
		}

		// 또는
//		Path saveFolder = Paths.get("d:\\");
//		try {
//			if(!Files.exists(saveFolder))
//			Files.createDirectories(saveFolder);
//			file.transferTo(saveFolder.resolve(Paths.get(file.getOriginalFilename())).normalize());
//			return 1;
//		} catch (IllegalStateException | IOException e) {
//			e.printStackTrace();
//			return 0;
//		}
	}

}
