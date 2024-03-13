package jp.ac.ohara.oharabank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import jp.ac.ohara.oharabank.model.BankAccount;
import jp.ac.ohara.oharabank.repository.BankAccountRepository;

@Service
@Transactional
public class BankAccountDetailService implements UserDetailsService{
	@Autowired
	private BankAccountRepository bankAccountRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("serach name : " + username);
		BankAccount bankaccount = this.bankAccountRepository.findByuserNameEquals(username); // emailで検索するので「EmailEquals」としている
		System.out.println(bankaccount.toString());
		return bankaccount;
	}
}
