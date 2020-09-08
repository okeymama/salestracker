package com.sales.salestracker.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sales.salestracker.dto.FileResponceDto;
import com.sales.salestracker.entity.FileEntity;
import com.sales.salestracker.repo.FileRepo;

@Service
public class FileService {

	@Autowired
	FileRepo fileRepo;

	public void uploadFile(Long id,MultipartFile file) throws IOException {

		System.out.println("Original File Byte Size - " + file.getBytes().length);

		FileEntity fileEntity = new FileEntity(file.getOriginalFilename(), file.getContentType(),
				//compressBytes(file.getBytes())
				file.getBytes()
				);
		fileEntity.setId(id);
		//System.out.println(Base64.getEncoder().encodeToString(file.getBytes()));
		System.out.println(file.getBytes().length);
		fileRepo.save(fileEntity);

	}


	public FileResponceDto getFile(Long id) throws IOException {

		final Optional<FileEntity> retrievedFile = fileRepo.findById(id);

		FileResponceDto img = new FileResponceDto(retrievedFile.get().getName(), retrievedFile.get().getType(),
				//decompressBytes(retrievedFile.get().getPicByte())
				retrievedFile.get().getPicByte()
				);
		System.out.println("dow>>>"+img.getFile().length);
		return img;

	}


	public static byte[] compressBytes(byte[] data) {

		Deflater deflater = new Deflater();

		deflater.setInput(data);

		deflater.finish();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);

		byte[] buffer = new byte[1024];

		while (!deflater.finished()) {

			int count = deflater.deflate(buffer);

			outputStream.write(buffer, 0, count);

		}

		try {

			outputStream.close();

		} catch (IOException e) {

		}

		System.out.println("Compressed File Byte Size - " + outputStream.toByteArray().length);

		return outputStream.toByteArray();

	}



	public static byte[] decompressBytes(byte[] data) {

		Inflater inflater = new Inflater();

		inflater.setInput(data);

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);

		byte[] buffer = new byte[1024];

		try {

			while (!inflater.finished()) {

				int count = inflater.inflate(buffer);

				outputStream.write(buffer, 0, count);

			}

			outputStream.close();

		} catch (IOException ioe) {

		} catch (DataFormatException e) {

		}

		return outputStream.toByteArray();

	}

}
