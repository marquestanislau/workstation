<div class="clazzes view">
<h2><?php echo __('Clazze'); ?></h2>
	<dl>
		<dt><?php echo __('Id'); ?></dt>
		<dd>
			<?php echo h($clazze['Clazze']['id']); ?>
			&nbsp;
		</dd>
		<dt><?php echo __('Nome'); ?></dt>
		<dd>
			<?php echo h($clazze['Clazze']['nome']); ?>
			&nbsp;
		</dd>
		<dt><?php echo __('Carreira'); ?></dt>
		<dd>
			<?php echo $this->Html->link($clazze['Carreira']['id'], array('controller' => 'carreiras', 'action' => 'view', $clazze['Carreira']['id'])); ?>
			&nbsp;
		</dd>
	</dl>
</div>
<div class="actions">
	<h3><?php echo __('Actions'); ?></h3>
	<ul>
		<li><?php echo $this->Html->link(__('Edit Clazze'), array('action' => 'edit', $clazze['Clazze']['id'])); ?> </li>
		<li><?php echo $this->Form->postLink(__('Delete Clazze'), array('action' => 'delete', $clazze['Clazze']['id']), array('confirm' => __('Are you sure you want to delete # %s?', $clazze['Clazze']['id']))); ?> </li>
		<li><?php echo $this->Html->link(__('List Clazzes'), array('action' => 'index')); ?> </li>
		<li><?php echo $this->Html->link(__('New Clazze'), array('action' => 'add')); ?> </li>
		<li><?php echo $this->Html->link(__('List Carreiras'), array('controller' => 'carreiras', 'action' => 'index')); ?> </li>
		<li><?php echo $this->Html->link(__('New Carreira'), array('controller' => 'carreiras', 'action' => 'add')); ?> </li>
		<li><?php echo $this->Html->link(__('List Escalaos'), array('controller' => 'escalaos', 'action' => 'index')); ?> </li>
		<li><?php echo $this->Html->link(__('New Escalao'), array('controller' => 'escalaos', 'action' => 'add')); ?> </li>
	</ul>
</div>
<div class="related">
	<h3><?php echo __('Related Escalaos'); ?></h3>
	<?php if (!empty($clazze['Escalao'])): ?>
	<table cellpadding = "0" cellspacing = "0">
	<tr>
		<th><?php echo __('Id'); ?></th>
		<th><?php echo __('Nome'); ?></th>
		<th><?php echo __('Categoria Id'); ?></th>
		<th><?php echo __('Clazze Id'); ?></th>
		<th class="actions"><?php echo __('Actions'); ?></th>
	</tr>
	<?php foreach ($clazze['Escalao'] as $escalao): ?>
		<tr>
			<td><?php echo $escalao['id']; ?></td>
			<td><?php echo $escalao['nome']; ?></td>
			<td><?php echo $escalao['categoria_id']; ?></td>
			<td><?php echo $escalao['clazze_id']; ?></td>
			<td class="actions">
				<?php echo $this->Html->link(__('View'), array('controller' => 'escalaos', 'action' => 'view', $escalao['id'])); ?>
				<?php echo $this->Html->link(__('Edit'), array('controller' => 'escalaos', 'action' => 'edit', $escalao['id'])); ?>
				<?php echo $this->Form->postLink(__('Delete'), array('controller' => 'escalaos', 'action' => 'delete', $escalao['id']), array('confirm' => __('Are you sure you want to delete # %s?', $escalao['id']))); ?>
			</td>
		</tr>
	<?php endforeach; ?>
	</table>
<?php endif; ?>

	<div class="actions">
		<ul>
			<li><?php echo $this->Html->link(__('New Escalao'), array('controller' => 'escalaos', 'action' => 'add')); ?> </li>
		</ul>
	</div>
</div>
