package com.aurionpro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.controller.AccountController;
import com.aurionpro.entity.Admin;
import com.aurionpro.entity.Document;
import com.aurionpro.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	private DocumentStorageService documentService;
	@Autowired
    private AccountController accountController;
	@Autowired
	private AdminRepository adminRepo;
	
	@Override
	public List<Admin> findAll() {
		return adminRepo.findAll();
	}

	@Override
	public Optional<Admin> findById(int admin_id) {
		return adminRepo.findById(admin_id);
	}

	@Override
	public void updateStatus(String status, int requestId) {
        if (status.equalsIgnoreCase("approved")) {
            documentService.updateStatus(status, requestId);
            Document document = documentService.getDocumentByRquestId(requestId);
            accountController.createAccount(document.getAccountTypeId(), document.getBalance(), document.getCustomerId(),document.getBankId());
        } else {
            documentService.updateStatus(status, requestId);
            // document table se row delete ho jaega
        }
    }

}
