delete from tb_license;
insert into tb_license(license_id, product_name, license_name, origanization_id) values('1','testProduct1', 'testLicense1', '11');
insert into tb_license(license_id, product_name, license_name, origanization_id) values('2','testProduct2', 'testLicense2', '12');
insert into tb_license(license_id, product_name, license_name, origanization_id) values('3','testProduct3', 'testLicense3', '13');

delete from tb_organization;
insert into tb_organization(organization_id, organization_name, contact_name, contact_email) values('11','testOrganization1', 'testContactName1', 'test1@email.com');
insert into tb_organization(organization_id, organization_name, contact_name, contact_email) values('12','testOrganization2', 'testContactName2', 'test2@email.com');
insert into tb_organization(organization_id, organization_name, contact_name, contact_email) values('13','testOrganization3', 'testContactName3', 'test3@email.com');

delete from product_entry;
insert into product_entry(identifier, name, model, size) values('13','testOrganization3', 'testContactName3', 'test3@email.com');
